package com.example.demo.data.graph;

import java.util.Objects;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Node
public class AbstractGraphNodeEntity implements IGraphNodeEntity, IIdentifiable {

	@Id
	@GeneratedValue
	protected Long graphId;

	private String guid;

	protected AbstractGraphNodeEntity() {

	}

	@Override
	public Long getGraphId() {

		return this.graphId;
	}

	@Override
	public void setGraphId(Long graphId) {

		this.graphId = graphId;
	}

	@Override
	public String getGuid() {

		return this.guid;
	}

	public void setGuid(String guid) {

		if (this.guid == null) {
			this.guid = guid;
		}
	}

	@Override
	public int hashCode() {

		return Objects.hash(graphId, guid);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractGraphNodeEntity)) {
			return false;
		}
		AbstractGraphNodeEntity other = (AbstractGraphNodeEntity) obj;
		return Objects.equals(graphId, other.graphId) && Objects.equals(guid, other.guid);
	}

}
