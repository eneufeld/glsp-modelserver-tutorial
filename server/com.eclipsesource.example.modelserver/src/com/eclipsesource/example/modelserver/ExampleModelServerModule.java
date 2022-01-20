package com.eclipsesource.example.modelserver;

import org.eclipse.emfcloud.modelserver.common.ModelServerPathParameters;
import org.eclipse.emfcloud.modelserver.common.codecs.Codec;
import org.eclipse.emfcloud.modelserver.common.utils.MapBinding;
import org.eclipse.emfcloud.modelserver.common.utils.MultiBinding;
import org.eclipse.emfcloud.modelserver.emf.common.ModelResourceManager;
import org.eclipse.emfcloud.modelserver.emf.configuration.EPackageConfiguration;
import org.eclipse.emfcloud.modelserver.glsp.notation.modelserver.EMSNotationModelServerModule;

import com.eclipsesource.example.modelserver.model.ExampleModelCodec;
import com.eclipsesource.example.modelserver.model.ExampleModelEPackageConfiguration;
import com.eclipsesource.example.modelserver.model.ExampleModelJsonCodec;

public class ExampleModelServerModule extends EMSNotationModelServerModule {

	@Override
	protected void configureEPackages(final MultiBinding<EPackageConfiguration> binding) {
		super.configureEPackages(binding);
		binding.add(ExampleModelEPackageConfiguration.class);
	}
	
	@Override
	protected void configureCodecs(final MapBinding<String, Codec> binding) {
		super.configureCodecs(binding);
		binding.put("model", ExampleModelCodec.class);
		binding.put(ModelServerPathParameters.FORMAT_JSON, ExampleModelJsonCodec.class);
	}

	@Override
	protected Class<? extends ModelResourceManager> bindModelResourceManager() {
		return ExampleModelResourceManager.class;
	}

}
