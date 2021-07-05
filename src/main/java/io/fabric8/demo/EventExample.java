package io.fabric8.demo;

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class EventExample {
    public static void main(String[] args) {
        try (KubernetesClient client = new DefaultKubernetesClient()) {
            client.v1().events().inNamespace("default").list().getItems()
                    .stream()
                    .map(Event::getMetadata)
                    .map(ObjectMeta::getName)
                    .forEach(System.out::println);
        }
    }
}
