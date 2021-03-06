package com.reactnativenavigation.viewcontrollers;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.Gravity;
import android.view.View;

import com.reactnativenavigation.parse.Options;
import com.reactnativenavigation.presentation.NavigationOptionsListener;
import com.reactnativenavigation.presentation.SideMenuOptionsPresenter;
import com.reactnativenavigation.views.Component;

import java.util.ArrayList;
import java.util.Collection;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class SideMenuController extends ParentController<DrawerLayout> implements NavigationOptionsListener {

	private ViewController centerController;
	private ViewController leftController;
	private ViewController rightController;

	public SideMenuController(final Activity activity, final String id, Options initialOptions) {
		super(activity, id, initialOptions);
	}

	@NonNull
	@Override
	protected DrawerLayout createView() {
        return new DrawerLayout(getActivity());
	}

    @Override
    public void sendOnNavigationButtonPressed(String buttonId) {
        centerController.sendOnNavigationButtonPressed(buttonId);
    }

    @NonNull
	@Override
	public Collection<ViewController> getChildControllers() {
		ArrayList<ViewController> children = new ArrayList<>();
		if (centerController != null) children.add(centerController);
		if (leftController != null) children.add(leftController);
		if (rightController != null) children.add(rightController);
		return children;
	}

    @Override
    public void applyChildOptions(Options options, Component child) {
        super.applyChildOptions(options, child);
        applyOnParentController(parentController ->
                ((ParentController) parentController).applyChildOptions(this.options, child)
        );
    }

    @Override
    public void mergeOptions(Options options) {
        this.options = this.options.mergeWith(options);
        new SideMenuOptionsPresenter(getView()).present(this.options.sideMenuRootOptions);
        this.options = this.options.copy().clearSideMenuOptions();
    }

    public void setCenterController(ViewController centerController) {
		this.centerController = centerController;
		View childView = centerController.getView();
		getView().addView(childView);
	}

	public void setLeftController(ViewController controller) {
		this.leftController = controller;
        getView().addView(controller.getView(), new LayoutParams(MATCH_PARENT, MATCH_PARENT, Gravity.LEFT));
	}

	public void setRightController(ViewController controller) {
		this.rightController = controller;
        getView().addView(controller.getView(), new LayoutParams(MATCH_PARENT, MATCH_PARENT, Gravity.RIGHT));
	}
}
