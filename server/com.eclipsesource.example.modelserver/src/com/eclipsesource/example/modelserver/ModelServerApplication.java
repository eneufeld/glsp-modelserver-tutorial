package com.eclipsesource.example.modelserver;

import org.eclipse.emfcloud.modelserver.emf.launch.ModelServerLauncher;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.eclipsesource.example.model.ModelPackage;

/**
 * This class controls all aspects of the application's execution
 */
public class ModelServerApplication implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		ModelPackage.eINSTANCE.eClass();
		final ModelServerLauncher launcher = new ModelServerLauncher(new ExampleModelServerModule());
		launcher.run();
		System.in.read();
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// nothing to do
	}
}
