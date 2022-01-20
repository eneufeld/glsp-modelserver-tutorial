package com.eclipsesource.example.glsp.server;

import org.eclipse.glsp.server.di.ServerModule;
import org.eclipse.glsp.server.protocol.GLSPServer;

import com.eclipsesource.example.glsp.modelserver.ExampleGLSPServer;

public class ExampleGLSPServerModule extends ServerModule {

	@Override
	protected Class<? extends GLSPServer> bindGLSPServer() {
		return ExampleGLSPServer.class;
	}

}
