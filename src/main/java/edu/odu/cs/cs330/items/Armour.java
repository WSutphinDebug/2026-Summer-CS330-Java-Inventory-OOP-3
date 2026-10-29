package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable implements Item
{
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %s%n",
        "  Def: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n",
        "  Emt: %s%n"
    );

    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();

        this.defense = 0;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement getDefense()
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();
        cpy.name = super.name;
        cpy.setDurability(this.getDurability());
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        cpy.setElement(this.getElement());
        cpy.setDefense(this.getDefense());

        // Replace the return
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour lhs = this;
        Armour rhsItem = (Armour) rhs;

           if(!(lhs.name.equals(rhsItem.name))){
            return false;
        }
        else if(!(lhs.getModifier().equals(rhsItem.getModifier()))){
            return false;
        }
        else if(!(lhs.getMaterial().equals(rhsItem.getMaterial()))){
            return false;
        }
        else if(lhs.getModifierLevel() != rhsItem.getModifierLevel()){
            return false;
        }
        else if(!(lhs.getElement().equals(rhsItem.getElement()))){
            return false;
        }
        else if(lhs.getDefense() != rhsItem.getDefense()){
            return false;
        }


        return this.name.equals(rhsItem.name)
            && this.getMaterial().equals(rhsItem.getMaterial())
            && this.getModifier().equals(rhsItem.getModifier())
            && this.getModifierLevel() == rhsItem.getModifierLevel()
            && this.getElement().equals(rhsItem.getElement())
            && this.getDefense() == rhsItem.getDefense();
    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(
            this.getName(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel(),
            this.getElement(),
            this.getDefense()
        );
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
         // Use String.format and the provided FMT_STR
        return String.join(
            System.lineSeparator(),
            String.format(FMT_STR, super.getName(), this.getDurability(), this.getDefense(), this.getMaterial(), this.getModifier(), 
            this.getModifierLevel(), this.getElement())
            
        );
    }
}




