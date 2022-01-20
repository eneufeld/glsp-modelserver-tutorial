package com.eclipsesource.example.glsp.server;

import java.util.Collections;
import java.util.List;

import org.eclipse.glsp.server.diagram.BaseDiagramConfiguration;
import org.eclipse.glsp.server.types.EdgeTypeHint;
import org.eclipse.glsp.server.types.ShapeTypeHint;

public class ExampleDiagramConfiguration extends BaseDiagramConfiguration {

	@Override
	public List<ShapeTypeHint> getShapeTypeHints() {
		return Collections.emptyList();
	}

	@Override
	public List<EdgeTypeHint> getEdgeTypeHints() {
		return Collections.emptyList();
	}
}
