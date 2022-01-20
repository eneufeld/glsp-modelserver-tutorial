package com.eclipsesource.example.glsp;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.glsp.server.launch.GLSPServerLauncher;
import org.eclipse.glsp.server.launch.SocketGLSPServerLauncher;

import com.eclipsesource.example.glsp.server.ExampleGLSPModule;
import com.eclipsesource.example.glsp.server.ExampleGLSPServerModule;
import com.eclipsesource.example.model.ModelPackage;

/**
 * This class controls all aspects of the application's execution
 */
public class GLSPApplication implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		ModelPackage.eINSTANCE.eClass();
		ExampleGLSPServerModule exampleServerModule = new ExampleGLSPServerModule();
		exampleServerModule.configureDiagramModule(new ExampleGLSPModule());
		final GLSPServerLauncher launcher = new SocketGLSPServerLauncher(exampleServerModule);
		launcher.start("localhost", 5007);
		System.in.read();
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// nothing to do
	}
}
