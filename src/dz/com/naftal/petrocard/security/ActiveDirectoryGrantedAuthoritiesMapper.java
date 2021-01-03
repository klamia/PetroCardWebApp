package dz.com.naftal.petrocard.security;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

/**
 * Maps the groups defined in LDAP nomenclature to roles for a specific user.
 */
public class ActiveDirectoryGrantedAuthoritiesMapper implements GrantedAuthoritiesMapper {

    // Constants for group defined in LDAP
    private String ROLE_ADMIN = "LDAP Admin Role";

    public ActiveDirectoryGrantedAuthoritiesMapper() {
    }

    @Override
	public Collection<? extends GrantedAuthority> mapAuthorities(
            final Collection<? extends GrantedAuthority> authorities) {
    	
        Set<SecurityContextAuthority> roles = EnumSet.noneOf(SecurityContextAuthority.class);

        for (GrantedAuthority authority : authorities) {
            // authority.getAuthority() returns the role in LDAP nomenclature
            if (ROLE_ADMIN.equals(authority.getAuthority())) {
                roles.add(SecurityContextAuthority.ROLE_ADMIN);
            }
        }
        return roles;
    }

}
