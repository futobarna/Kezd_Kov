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

import com.z80h3x.kezd_kov.data.network.models.Monster

/**
 * 
 * @param count 
 * @param results 
 */
data class MonsterList (
    val count: Int? = null,
    val results: Array<Monster>? = null
) {

}
