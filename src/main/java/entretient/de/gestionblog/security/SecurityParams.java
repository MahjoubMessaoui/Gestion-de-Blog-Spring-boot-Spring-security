package entretient.de.gestionblog.security;

public interface SecurityParams {
    String JWT_HEADER_NAME="Authorization";
    String SECRET="mahjoub.messaoui@yahoo.fr";
    long EXPIRATION=10*24*3600;
    String HEADER_PREFIX="Bearer ";


}
