package com.java.energytracker.architecture;

import com.structurizr.Workspace;
import com.structurizr.api.StructurizrClient;
import com.structurizr.api.StructurizrClientException;
import com.structurizr.model.Container;
import com.structurizr.model.Person;
import com.structurizr.model.SoftwareSystem;
import com.structurizr.model.Tags;
import com.structurizr.view.ContainerView;
import com.structurizr.view.Shape;
import com.structurizr.view.Styles;
import com.structurizr.view.SystemContextView;
import com.structurizr.view.ViewSet;

public class Architecture {

	private static final String DEVICE = "DEVICE";
	private static final String CURRENT_SYSTEM = "CURRENT_SYSTEM";
	private static final String DATABASE = "DATABASE";
	private static final Workspace workspace = new Workspace("Energy Consumption Tracking System", "Architecture of the Energy Consumption Tracking System.");
	private static SoftwareSystem currentSystem;
	
	public static void main(String[] args) throws StructurizrClientException {
		
		currentSystem = createSoftwareSystem("Energy Consumption Tracking System", "Software System that tracks energy consumption of various devices, suggests goals and provides incentives for the customers who achieved the goals.", CURRENT_SYSTEM);

		// Users of the system
		Person customer = createUser("Customer", "A customer of Energy Consumption Tracking System.");
		SoftwareSystem thirdPartyApp = createSoftwareSystem("Server-Side App", "An application that needs energy consumption data.");
		SoftwareSystem iotDevices = createSoftwareSystem("IoT Devices", "Various IoT devices that can publish energy consumption data.", DEVICE);
		
		customer.uses(currentSystem, "Uses");
		thirdPartyApp.uses(currentSystem, "Uses");		
		currentSystem.uses(iotDevices, "Takes telemetry data from");
		
		// Containers
		Container cassandraContainer = createDatabaseContainer("Telemetry Data Store", "Stores energy consumption data", "Cassandra Database");
		Container mySQLContainer = createDatabaseContainer("Incentive Data Store", "Stores goals, badges and incentives information", "MySQL Database");
		Container clientAppContainer = createContainer("Client Application", "Allows customer to view energy consumption data", "HTML, CSS and JavaScript");
		Container telemetryApiContainer = createContainer("Telemetry API", "Provides JSON-based Web API", "Java, Spring MVC and Web Sockets");
		Container incentiveApiContainer = createContainer("Incentive API", "Provides JSON-based Web API", "Java and Spring MVC");
		Container webAppContainer = createContainer("Web Application", "Serves static and dynamic content to users", "Java and Spring MVC");
		Container mqttContainer = createContainer("MQTT Service", "Enables IoT devices to communicate using MQTT protocol", "Java and Spring MVC");
		Container coapContainer = createContainer("CoAP Service", "Enables IoT devices to communicate using CoAP protocol", "Java and Spring MVC");

		customer.uses(clientAppContainer, "Uses");
		thirdPartyApp.uses(telemetryApiContainer, "Uses", "JSON/HTTPS");
		webAppContainer.uses(clientAppContainer, "Delivers", "HTTPS");
		clientAppContainer.uses(incentiveApiContainer, "Uses", "JSON/HTTPS");
		clientAppContainer.uses(telemetryApiContainer, "Uses", "JSON/HTTPS");
		telemetryApiContainer.uses(cassandraContainer, "Reads from and writes to", "JDBC");
		incentiveApiContainer.uses(telemetryApiContainer, "Takes telemetry analytics from", "JSON/HTTPS");
		incentiveApiContainer.uses(mySQLContainer, "Reads from and writes to", "JDBC");
		iotDevices.uses(mqttContainer, "Publishes telemetry data", "MQTT");
		iotDevices.uses(coapContainer, "Publishes telemetry data", "CoAP");
		mqttContainer.uses(cassandraContainer, "Reads from and writes to", "JDBC");
		coapContainer.uses(cassandraContainer, "Reads from and writes to", "JDBC");
		
		createContextView(workspace, currentSystem);
		createContainerView(workspace, currentSystem);			
		
		applyStyles(workspace);
				
		submitArchitecture(workspace);
	}
	
	private static Person createUser(String name, String description) {
		return workspace.getModel().addPerson(name, description);
	}
	
	private static SoftwareSystem createSoftwareSystem(String name, String description) {
		return workspace.getModel().addSoftwareSystem(name, description);		
	}
	
	private static SoftwareSystem createSoftwareSystem(String name, String description, String tag) {
		SoftwareSystem softwareSystem = createSoftwareSystem(name, description);
		softwareSystem.addTags(tag);
		return softwareSystem;
	}
	
	private static Container createContainer(String name, String description, String technology) {
		return currentSystem.addContainer(name, description, technology);
	}
	
	private static Container createDatabaseContainer(String name, String description, String technology) {
		Container container = currentSystem.addContainer(name, description, technology);
		container.addTags(DATABASE);
		return container;
	}

	private static void applyStyles(Workspace workspace) {
		ViewSet views = workspace.getViews();
		Styles styles = views.getConfiguration().getStyles();
		
		styles.addElementStyle(Tags.SOFTWARE_SYSTEM).background("#1168bd").color("#ffffff").shape(Shape.RoundedBox);
		styles.addElementStyle(CURRENT_SYSTEM).background("#000000").color("#ffffff").shape(Shape.RoundedBox);
		styles.addElementStyle(DEVICE).background("#1168bd").color("#ffffff").shape(Shape.Circle);
		styles.addElementStyle(DATABASE).shape(Shape.Cylinder);
		styles.addElementStyle(Tags.CONTAINER).background("#438dd5").color("#ffffff");
		styles.addElementStyle(Tags.PERSON).background("#08427b").color("#ffffff").shape(Shape.Person);
	}
	
	private static void createContextView(Workspace workspace, SoftwareSystem softwareSystem) {
		ViewSet views = workspace.getViews();
		
		SystemContextView contextView = views.createSystemContextView(softwareSystem, "SystemContext",
				"System Context diagram that explains who uses the system and what are all the external systems this system uses.");
		contextView.addAllSoftwareSystems();
		contextView.addAllPeople();
	}
	
	private static void createContainerView(Workspace workspace, SoftwareSystem softwareSystem) {
		ViewSet views = workspace.getViews();
		
		ContainerView containerView = views.createContainerView(softwareSystem, "SystemContainer",
				"System Container diagram that shows different containers that are part of the system.");
		containerView.addAllContainers();
		containerView.addAllSoftwareSystems();
		containerView.addAllPeople();
	}
	
	private static void submitArchitecture(Workspace workspace) throws StructurizrClientException {
		StructurizrClient structurizrClient = new StructurizrClient("d4bfc4cf-49bb-4a09-bec5-437ac710ced2", "9fa5c76c-5948-4e3b-92e0-501e3e581168");
		structurizrClient.setMergeFromRemote(true);
		structurizrClient.putWorkspace(38301, workspace);
	}
}
