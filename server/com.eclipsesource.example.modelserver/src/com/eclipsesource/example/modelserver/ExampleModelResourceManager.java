package com.eclipsesource.example.modelserver;

import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emfcloud.modelserver.emf.common.watchers.ModelWatchersManager;
import org.eclipse.emfcloud.modelserver.emf.configuration.EPackageConfiguration;
import org.eclipse.emfcloud.modelserver.emf.configuration.ServerConfiguration;
import org.eclipse.emfcloud.modelserver.glsp.notation.modelserver.EMSModelResourceManager;

import com.google.inject.Inject;

public class ExampleModelResourceManager extends EMSModelResourceManager {

	@Inject
	public ExampleModelResourceManager(Set<EPackageConfiguration> configurations, AdapterFactory adapterFactory,
			ServerConfiguration serverConfiguration, final ModelWatchersManager watchersManager) {
		super(configurations, adapterFactory, serverConfiguration, watchersManager);
	}

	@Override
	protected String getSemanticModelFileExtension() {
		return "model";
	}

}
