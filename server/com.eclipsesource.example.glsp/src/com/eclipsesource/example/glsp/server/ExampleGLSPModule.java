package com.eclipsesource.example.glsp.server;

import org.eclipse.emfcloud.modelserver.glsp.ids.DefaultGLSPModule;
import org.eclipse.glsp.server.diagram.DiagramConfiguration;

import com.eclipsesource.example.model.Person;

public class ExampleGLSPModule extends DefaultGLSPModule {

	@Override
	protected Class<? extends DiagramConfiguration> bindDiagramConfiguration() {
		return ExampleDiagramConfiguration.class;
	}

	@Override
	public String getDiagramType() {
		return "example-diagram";
	}

	@Override
	protected String getSemanticModelExtension() {
		return "model";
	}

	@Override
	protected Class<ExampleRootSemanticToGModelTransformer> bindRootSemanticToGModelTransformer() {
		return ExampleRootSemanticToGModelTransformer.class;
	}

	@Override
	protected Class<Person> getSemanticModelRootClass() {
		return Person.class;
	}
	
}
