package bg.tu_varna.sit.oop1.models;

import bg.tu_varna.sit.oop1.enums.UserMessages;
import bg.tu_varna.sit.oop1.exceptions.SubjectException;
import java.util.Objects;

/**
 * The Subject class represents a subject with attributes name and type.
 */
public class Subject {
    private String name;
    private String type;

    /**
     * Constructs a new Subject with the specified name and type.
     *
     * @param name The name of the subject
     * @param type The type of the subject
     * @throws SubjectException if any parameter validation fails.
     */
    public Subject (String name, String type) throws SubjectException {
        setName(name);
        setType(type);
    }

    /**
     * Gets the name of the subject.
     *
     * @return The name of the subject.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the subject.
     *
     * @param name The name to set.
     * @throws SubjectException if the name is null or empty.
     */
    public void setName (String name) throws SubjectException {
        if (name == null || name.isEmpty()) {
            throw new SubjectException(UserMessages.SUBJECT_NAME_NULL_VALUE.message);
        }

        this.name = name;
    }

    /**
     * Gets the type of the subject.
     *
     * @return The type of the subject.
     */
    public String getType () {
        return  this.type;
    }

    /**
     * Sets the type of the subject.
     *
     * @param type The type to set.
     * @throws SubjectException if the type is not "mandatory" or "optional".
     */
    public void setType (String type) throws SubjectException {
        if (!type.equalsIgnoreCase("mandatory") && !type.equalsIgnoreCase("optional")) {
            throw new SubjectException(UserMessages.SUBJECT_TYPE_WRONG_VALUE.message);
        }

        this.type = type.toLowerCase();
    }


    /**
     * Compares this subject with another object for equality.
     * Two subjects are considered equal when they have the same name and type,
     * ignoring letter case.
     *
     * @param obj The object to compare with this subject.
     * @return true if the subjects have the same name and type, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Subject subject = (Subject) obj;

        return Objects.equals(name.toLowerCase(), subject.name.toLowerCase())
                && Objects.equals(type.toLowerCase(), subject.type.toLowerCase());
    }

    /**
     * Generates a hash code for this subject.
     * The hash code is based on the subject name and type,
     * ignoring letter case.
     *
     * @return The hash code of the subject.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), type.toLowerCase());
    }
}
