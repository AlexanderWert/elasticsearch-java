/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.core.search;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.json.UnionDeserializer;
import co.elastic.clients.util.ModelTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.ObjectBuilderBase;
import co.elastic.clients.util.TaggedUnion;
import co.elastic.clients.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: _global.search._types.TrackHits
// union type: Union[]
@JsonpDeserializable
public class TrackHits implements TaggedUnion<Object>, JsonpSerializable {

	public static final String COUNT = "count";
	public static final String ENABLED = "enabled";

	private final String _type;
	private final Object _value;

	@Override
	public final String _type() {
		return _type;
	}

	@Override
	public final Object _get() {
		return _value;
	}

	public TrackHits(String type, Object value) {
		this._type = type;
		this._value = value;
	}

	public String _toJsonString() {
		switch (_type) {
			case "count" :
				return String.valueOf(this.count());
			case "enabled" :
				return String.valueOf(this.enabled());

			default :
				throw new IllegalStateException("Unknown type " + _type);
		}
	}
	private TrackHits(Builder builder) {

		this._type = ModelTypeHelper.requireNonNull(builder._type, builder, "<variant type>");
		this._value = ModelTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static TrackHits of(Function<Builder, ObjectBuilder<TrackHits>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Is this variant instance of kind {@code count}?
	 */
	public boolean _isCount() {
		return COUNT.equals(_type());
	}

	/**
	 * Get the {@code count} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code count} kind.
	 */
	public Integer count() {
		return TaggedUnionUtils.get(this, COUNT);
	}

	/**
	 * Is this variant instance of kind {@code enabled}?
	 */
	public boolean _isEnabled() {
		return ENABLED.equals(_type());
	}

	/**
	 * Get the {@code enabled} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code enabled} kind.
	 */
	public Boolean enabled() {
		return TaggedUnionUtils.get(this, ENABLED);
	}

	@Override
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		if (_value instanceof JsonpSerializable) {
			((JsonpSerializable) _value).serialize(generator, mapper);
		} else {
			switch (_type) {
				case COUNT :
					generator.write(((Integer) this._value));

					break;
				case ENABLED :
					generator.write(((Boolean) this._value));

					break;
			}
		}

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<TrackHits> {
		private String _type;
		private Object _value;

		public Builder count(Integer v) {
			this._type = COUNT;
			this._value = v;
			return this;
		}

		public Builder enabled(Boolean v) {
			this._type = ENABLED;
			this._value = v;
			return this;
		}

		public TrackHits build() {
			_checkSingleUse();
			return new TrackHits(this);
		}

	}

	private static JsonpDeserializer<TrackHits> buildTrackHitsDeserializer() {
		return new UnionDeserializer.Builder<>(TrackHits::new, false)
				.addMember("count", JsonpDeserializer.integerDeserializer())
				.addMember("enabled", JsonpDeserializer.booleanDeserializer()).build();
	}

	public static final JsonpDeserializer<TrackHits> _DESERIALIZER = JsonpDeserializer
			.lazy(TrackHits::buildTrackHitsDeserializer);
}