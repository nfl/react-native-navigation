# Navigation

## Properties

- Element (`React.ComponentType<object>`)

## Methods

### `registerComponent(componentName: string, getComponentClassFunc: ComponentProvider): void`

[source](/lib/src//Navigation.ts#52)

Every navigation component in your app must be registered with a unique name.
The component itself is a traditional React component extending React.Component.

#### Arguments
- componentName (`string`)
- getComponentClassFunc (`ComponentProvider`)

#### Returns
- (`void`)

### `setRoot(layout: any): Promise<any>`

[source](/lib/src//Navigation.ts#59)

Reset the app to a new layout

#### Arguments
- layout (`any`)

#### Returns
- (`Promise<any>`)

### `setDefaultOptions(options: any): void`

[source](/lib/src//Navigation.ts#66)

Set default options to all screens. Useful for declaring a consistent style across the app.

#### Arguments
- options (`any`)

#### Returns
- (`void`)

### `mergeOptions(componentId: string, options: any): void`

[source](/lib/src//Navigation.ts#73)

Change a component's navigation options

#### Arguments
- componentId (`string`)
- options (`any`)

#### Returns
- (`void`)

### `showModal(layout: any): Promise<any>`

[source](/lib/src//Navigation.ts#80)

Show a screen as a modal.

#### Arguments
- layout (`any`)

#### Returns
- (`Promise<any>`)

### `dismissModal(componentId: string): Promise<any>`

[source](/lib/src//Navigation.ts#87)

Dismiss a modal by componentId. The dismissed modal can be anywhere in the stack.

#### Arguments
- componentId (`string`)

#### Returns
- (`Promise<any>`)

### `dismissAllModals(): Promise<any>`

[source](/lib/src//Navigation.ts#94)

Dismiss all Modals

#### Returns
- (`Promise<any>`)

### `push(componentId: string, layout: any): Promise<any>`

[source](/lib/src//Navigation.ts#101)

Push a new layout into this screen's navigation stack.

#### Arguments
- componentId (`string`)
- layout (`any`)

#### Returns
- (`Promise<any>`)

### `pop(componentId: string, params: any): Promise<any>`

[source](/lib/src//Navigation.ts#108)

Pop a component from the stack, regardless of it's position.

#### Arguments
- componentId (`string`)
- params (`any`)

#### Returns
- (`Promise<any>`)

### `popTo(componentId: string): Promise<any>`

[source](/lib/src//Navigation.ts#115)

Pop the stack to a given component

#### Arguments
- componentId (`string`)

#### Returns
- (`Promise<any>`)

### `popToRoot(componentId: string): Promise<any>`

[source](/lib/src//Navigation.ts#122)

Pop the component's stack to root.

#### Arguments
- componentId (`string`)

#### Returns
- (`Promise<any>`)

### `setStackRoot(componentId: string, layout: any): Promise<any>`

[source](/lib/src//Navigation.ts#129)

Sets new root component to stack.

#### Arguments
- componentId (`string`)
- layout (`any`)

#### Returns
- (`Promise<any>`)

### `showOverlay(layout: any): Promise<any>`

[source](/lib/src//Navigation.ts#136)

Show overlay on top of the entire app

#### Arguments
- layout (`any`)

#### Returns
- (`Promise<any>`)

### `dismissOverlay(componentId: string): Promise<any>`

[source](/lib/src//Navigation.ts#143)

dismiss overlay by componentId

#### Arguments
- componentId (`string`)

#### Returns
- (`Promise<any>`)

### `events(): EventsRegistry`

[source](/lib/src//Navigation.ts#150)

Obtain the events registry instance

#### Returns
- (`EventsRegistry`)

