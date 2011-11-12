package de.himberger.jackson.builder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Configuration {

	private final ServerConfiguration server;
	
	private final List<PluginConfiguration> plugins;

	public static class Builder {
		
		private ServerConfiguration server;
		private List<PluginConfiguration> plugins = Collections.<PluginConfiguration>emptyList();		

		public ServerConfiguration getServer() {
			return server;
		}

		public void setServer(ServerConfiguration server) {
			this.server = server;
		}
		
		public List<PluginConfiguration> getPlugins() {
			return plugins;
		}

		//TODO: This should be done via an add method
		public void setPlugins(List<PluginConfiguration> plugins) {
			this.plugins = plugins;
		}

		public Configuration create() {
			return new Configuration(this);
		}
		
	}
	
	private Configuration(Builder builder) {
		super();
		this.server = builder.getServer();
		this.plugins = new ArrayList<PluginConfiguration>(builder.getPlugins());
	}

	@BuilderMethod
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public List<PluginConfiguration> getPlugins() {
		return plugins;
	}

	public ServerConfiguration getServer() {
		return server;
	}
	
}