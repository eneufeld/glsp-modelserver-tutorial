package com.eclipsesource.example.glsp.server;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emfcloud.modelserver.emf.configuration.EPackageConfiguration;

import com.eclipsesource.example.model.ModelPackage;

public class ExampleModelEPackageConfiguration implements EPackageConfiguration {

	@Override
	public String getId() {
		return ModelPackage.eINSTANCE.getNsURI();
	}

	@Override
	public Collection<String> getFileExtensions() {
		return Arrays.asList("model","json");
	}

	@Override
	public void registerEPackage() {
		ModelPackage.eINSTANCE.eClass();
	}

}
