package com.eclipsesource.example.glsp.modelserver;

import java.net.MalformedURLException;

import org.eclipse.emfcloud.modelserver.client.ModelServerClient;
import org.eclipse.emfcloud.modelserver.glsp.EMSGLSPServer;
import org.eclipse.emfcloud.modelserver.glsp.ids.DefaultModelServerClient;

import com.eclipsesource.example.glsp.server.ExampleModelEPackageConfiguration;

public class ExampleGLSPServer extends EMSGLSPServer {

	@Override
	protected ModelServerClient createModelServerClient(final String modelServerURL) throws MalformedURLException {
		return new DefaultModelServerClient(modelServerURL, new ExampleModelEPackageConfiguration());
	}
}
