/**
* Kezdeményezés Követő
* This is a mobil client for tracking initiative in D&D and other ttrpgs.
*
* OpenAPI spec version: 1.0.0
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package com.z80h3x.kezd_kov.data.network.models

/**
 * 
 * @param index 
 * @param name 
 * @param size 
 * @param type 
 * @param subtype 
 * @param alignment 
 * @param armor_class 
 * @param hit_points 
 * @param hit_dice 
 * @param forms 
 * @param speed 
 * @param strength 
 * @param dexterity 
 * @param constitution 
 * @param intelligence 
 * @param wisdom 
 * @param charisma 
 * @param proficiencies
 * @param damage_vulnerabilities
 * @param damage_resistances 
 * @param damage_immunities 
 * @param condition_immunities 
 * @param senses 
 * @param languages 
 * @param challenge_rating 
 * @param special_abilities 
 * @param actions 
 * @param legendary_actions 
 * @param url 
 */
data class Monster (
    val index: String? = null,
    val name: String? = null,
    val size: String? = null,
    val type: String? = null,
    val subtype: String? = null,
    val alignment: String? = null,
    val armor_class: Int? = null,
    val hit_points: Int? = null,
    val hit_dice: String? = null,
    val forms: Any? = null,
    val speed: Any? = null,
    val strength: Int? = null,
    val dexterity: Int? = null,
    val constitution: Int? = null,
    val intelligence: Int? = null,
    val wisdom: Int? = null,
    val charisma: Int? = null,
    val proficiencies: Array<Proficiency>? = null,
    val damage_vulnerabilities: Array<String>? = null,
    val damage_resistances: Array<String>? = null,
    val damage_immunities: Array<String>? = null,
    val condition_immunities: Array<Condition>? = null,
    val senses: Any? = null,
    val languages: String? = null,
    val challenge_rating: java.math.BigDecimal? = null,
    val special_abilities: Array<SpecialAbility>? = null,
    val actions: Array<Action>? = null,
    val legendary_actions: Array<LegendaryAction>? = null,
    val url: String? = null
) {
    fun createDescription(): String {
        val st = if (subtype != null) {
            " ($subtype)"
        } else {
            ""
        }
        return "$size $type$st, $alignment\nArmor Class $armor_class\nHit Points $hit_points ($hit_dice)"
    }
}

