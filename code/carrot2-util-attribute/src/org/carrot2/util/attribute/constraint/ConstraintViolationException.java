package org.carrot2.util.attribute.constraint;

import java.lang.annotation.Annotation;

import org.carrot2.util.attribute.Attribute;

/**
 * An exception thrown when an attempt is made to bind attribute values that do not meet
 * the constraints.
 */
@SuppressWarnings("serial")
public class ConstraintViolationException extends RuntimeException
{
    /**
     * Value that does not meet the constraints.
     */
    public final Object offendingValue;

    /**
     * Constraints that were not met by the {@link #offendingValue}.
     */
    public final Annotation [] annotations;

    /**
     * Key of the involved {@link Attribute} as defined in {@link Attribute#key()}.
     */
    public final String key;

    /**
     * Creates a new {@link ConstraintViolationException}.
     */
    public ConstraintViolationException(String key, Object offendngValue,
        Annotation... annotations)
    {
        this.offendingValue = offendngValue;
        this.annotations = annotations;
        this.key = key;
    }

    @Override
    public String getMessage()
    {
        return "Value: " + offendingValue + " of attribute: " + key
            + " violates constraints: " + annotations;
    }
}
