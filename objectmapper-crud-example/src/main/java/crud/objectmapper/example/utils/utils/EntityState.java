package crud.objectmapper.example.utils.utils;

import javax.validation.ValidationException;

public enum EntityState {

	INACTIVE, // 0

	ACTIVE; // 1

	public EntityState invert(EntityState status) {
		// verify current is equal to status
		if (!status.equals(this))
			throw new ValidationException("Entity alread has the state you are trying to set it to");

		if (INACTIVE.name().equals(name()))
			return ACTIVE;
		else
			return INACTIVE;
	}
}