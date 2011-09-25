package com.nyaruka.app.auth;

import com.nyaruka.db.Record;
import com.nyaruka.json.JSON;

public class Permission {
	
	public Permission(Record r){
		JSON data = r.getData();		
		m_slug = data.getString("slug");
		m_id = r.getId();

		if (data.has("description")) m_description = data.getString("description");
	}
	
	public Permission(String slug, String name, String description){
		m_slug = slug;
		m_description = description;
	}
	
	public Permission(String slug){
		m_slug = slug;
	}
	
	public JSON toJSON(){
		JSON json = new JSON();
		json.put("slug", m_slug);
		if (m_description != null) json.put("description", m_description);
		if (m_id > 0) json.put("id", m_id);
		return json;
	}

	public String getDescription(){ return m_description; }
	public void setDescription(String description){ m_description = description; }
	
	public String getSlug(){ return m_slug; }
	public long getId(){ return m_id; }
	
	public boolean isGranted(){	return m_granted; }
	public void setGranted(boolean granted){ m_granted = granted; }
	
	/** transient variable for whether this permission is granted for a user */
	private boolean m_granted;
	
	private long m_id;
	private String m_slug;
	private String m_description;
}
