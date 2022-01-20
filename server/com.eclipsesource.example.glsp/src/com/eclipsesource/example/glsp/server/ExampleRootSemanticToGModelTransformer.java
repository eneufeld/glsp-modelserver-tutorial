package com.eclipsesource.example.glsp.server;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emfcloud.modelserver.glsp.model.RootSemanticToGModelTransformer;
import org.eclipse.emfcloud.modelserver.glsp.notation.Diagram;
import org.eclipse.emfcloud.modelserver.glsp.notation.Shape;
import org.eclipse.glsp.graph.DefaultTypes;
import org.eclipse.glsp.graph.GGraph;
import org.eclipse.glsp.graph.GModelElement;
import org.eclipse.glsp.graph.builder.impl.GNodeBuilder;
import org.eclipse.glsp.graph.util.GConstants;
import org.eclipse.glsp.graph.util.GraphUtil;

import com.eclipsesource.example.model.Person;
import com.eclipsesource.example.model.Task;

public class ExampleRootSemanticToGModelTransformer extends RootSemanticToGModelTransformer<Task> {

	
	@Override
	public GGraph create(Diagram notationDiagram) {
		GGraph graph = getOrCreateRoot();

		if (notationDiagram.getSemanticElement().getResolvedElement() != null) {
			Person model = (Person) notationDiagram.getSemanticElement().getResolvedElement();

			graph.setId(toId(model));

			List<GModelElement> tasks = model.getTasks().stream().map(task -> create(task))
					.collect(Collectors.toList());
			graph.getChildren().addAll(tasks);

		}
		return graph;
	}

	@Override
	public GModelElement create(Task task) {
		GNodeBuilder builder = new GNodeBuilder(DefaultTypes.NODE).id(toId(task)).layout(GConstants.Layout.VBOX);
		getModelState().getIndex().getNotation(task, Shape.class).ifPresent(shape -> {
			if (shape.getPosition() != null) {
				builder.position(GraphUtil.copy(shape.getPosition()));
			}
			if (shape.getSize() != null) {
				builder.size(GraphUtil.copy(shape.getSize()));
			}
		});

		return builder.build();
	}

}
