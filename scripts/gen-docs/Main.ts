import * as fs from 'fs';
import { ReflectionsReader } from './ReflectionsReader';
import { MarkdownCreator } from './MarkdownCreator';
import * as Handlebars from 'handlebars';

const MD_RELATIVE_LINK = `/lib/src/`;
const OUTPUT_DIR = `${__dirname}/../../docs/api`;
const TEMPLATES_DIR = `${__dirname}/templates`;
const TSCONFIG = JSON.parse(fs.readFileSync(`${__dirname}/../../tsconfig.json`).toString());

class Main {
  public run() {
    const handlebarsFn = this.setupHandlebars();

    const reflection = new ReflectionsReader(TSCONFIG).read('./lib/src/Navigation.ts');
    const markdown = new MarkdownCreator(MD_RELATIVE_LINK, handlebarsFn).create(reflection);

    fs.writeFileSync(`${OUTPUT_DIR}/Navigation.md`, markdown, { encoding: 'utf8' });
  }

  private setupHandlebars() {
    const mainTemplate = fs.readFileSync(`${TEMPLATES_DIR}/main.hbs`).toString();
    const classTemplate = fs.readFileSync(`${TEMPLATES_DIR}/class.hbs`).toString();
    const methodTemplate = fs.readFileSync(`${TEMPLATES_DIR}/method.hbs`).toString();

    Handlebars.registerPartial('class', classTemplate);
    Handlebars.registerPartial('method', methodTemplate);

    return Handlebars.compile(mainTemplate, { strict: true, noEscape: true });
  }
}

new Main().run();
