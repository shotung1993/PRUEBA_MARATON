package pe.lacafetalab.pao.shared.utils;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;

public class AccessAnotherRole {

    private AccessAnotherRole() {
        super();
    }

    public static Boolean verfyEmpty(String userIdToAccess, String userRoleToSAccess) {
        if ((userIdToAccess != null && !userIdToAccess.isBlank()) && (userRoleToSAccess == null || userRoleToSAccess.isBlank())) {
            throw new BadRequestException(ErrorConstantsShared.EMPTY_VALUE,
                    "You are entering User-Id-To-Access but not User-Role-To-Access");
        }
        if ((userIdToAccess == null || userIdToAccess.isBlank()) && (userRoleToSAccess != null && !userRoleToSAccess.isBlank())) {
            throw new BadRequestException(ErrorConstantsShared.EMPTY_VALUE,
                    "You are entering User-Role-To-Access but not User-Id-To-Access");
        }
        return (userIdToAccess != null && userRoleToSAccess != null && !userIdToAccess.isBlank() && !userRoleToSAccess.isBlank());
    }
}
