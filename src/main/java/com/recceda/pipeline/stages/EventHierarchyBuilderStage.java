package com.recceda.pipeline.stages;

import com.recceda.model.EventNode;
import com.recceda.model.event.Event;
import com.recceda.model.event.Page;
import com.recceda.pipeline.PipelineStage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EventHierarchyBuilderStage implements PipelineStage<List<EventNode>, List<EventNode>> {

    private final String stageName = "EventHierarchyBuilderStage";

    @Override
    public List<EventNode> process(Object input) {
        List<EventNode> eventNodes = (List<EventNode>) input;
        Map<String, List<EventNode>> groupedEvents = eventNodes.stream()
                .collect(Collectors.groupingBy(this::getEventPath));
        List<EventNode> enrichedEventNodes = new ArrayList<>();

        for (Map.Entry<String, List<EventNode>> entry : groupedEvents.entrySet()) {
            String path = entry.getKey();
            List<EventNode> nodes = entry.getValue();
            EventNode parentNode = buildParentNode(path, nodes);
            nodes.forEach(node -> node.setParentId(parentNode.getId()));
            nodes.forEach(node -> node.setParentId(parentNode.getId()));
            enrichedEventNodes.addAll(nodes);
            enrichedEventNodes.add(parentNode);
        }

        return enrichedEventNodes;
    }

    public EventNode buildParentNode(String path, List<EventNode> nodes) {
        System.out.println("Building parent node for path: " + path);
        int level = Objects.equals(path, "/") ? 0 : path.split("/").length - 1;
        Event event = new Event();
        Page page = new Page();
        page.setPath(path);
        event.setPage(page);
        EventNode parentNode = new EventNode(event, level);
        parentNode.setChildren(nodes.stream().map(EventNode::getId).collect(Collectors.toList()));
        parentNode.setChildCount(nodes.size());
        return parentNode;
    }

    public String getEventPath(EventNode eventNode) {
        return eventNode.getEvent().getPage().getPath();
    }

    @Override
    public String getName() {
        return stageName;
    }


}
