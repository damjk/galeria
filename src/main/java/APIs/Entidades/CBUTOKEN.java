package APIs.Entidades;

public class CBUTOKEN {

	public String token_type;
	public String access_token;
	public String expires_in;
	public String scope;
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getAcess_token() {
		return access_token;
	}
	public void setAcess_token(String acess_token) {
		this.access_token = acess_token;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}



}
