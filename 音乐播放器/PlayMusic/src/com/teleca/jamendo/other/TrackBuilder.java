/*
 * Copyright (C) 2009 Teleca Poland Sp. z o.o. <android@teleca.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teleca.jamendo.other;

import org.json.JSONException;
import org.json.JSONObject;

import com.teleca.jamendo.model.Track;

/**
 * @author Lukasz Wisniewski
 */
public class TrackBuilder extends JSONBuilder<Track>  {

	@Override
	public Track build(JSONObject jsonObject) throws JSONException {
		Track track = new Track();
		track.setDuration(jsonObject.getInt("duration"));
		track.setId(jsonObject.getInt("id"));
		track.setName(jsonObject.getString("name"));
		track.setStream(jsonObject.getString("stream"));
		try {
			track.setRating(jsonObject.getDouble("rating"));
		} catch (JSONException e) {
			track.setRating(-1);
		}
		track.setUrl(jsonObject.getString("url"));
		try {
			track.setNumAlbum(jsonObject.getInt("numalbum"));
		} catch (JSONException e) {
			track.setNumAlbum(0);
		}
		return track;
	}

}
