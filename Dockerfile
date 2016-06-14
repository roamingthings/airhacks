FROM airhacks/wildfly
MAINTAINER Adam Bien, adam-bien.com
COPY contacts/target/contacts.war ${DEPLOYMENT_DIR}