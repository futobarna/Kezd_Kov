package com.z80h3x.kezd_kov

import com.z80h3x.kezd_kov.data.generic.BaseCharacter
import com.z80h3x.kezd_kov.domain.interactors.CharacterInteractor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class CharacterInteractorTest {
    @Inject
    lateinit var charInteractor: CharacterInteractor

    @Before
    fun setup() {
        InjectorOfTests.inject(this)
    }

    @Test
    fun `test getting monsters from network are as expected`() = runBlockingTest {
        val monsters = charInteractor.getAllMonsters()
        Assert.assertEquals(monsters.size, 1)
    }

    @Test
    fun `test getting single monster from network is as expected`() = runBlockingTest {
        val monster = charInteractor.getMonsterByName("axe-beak")
        Assert.assertEquals(monster.description, "Large beast, unaligned\nArmor Class 11\nHit Points 19 (3d10)")
    }

    @Test
    fun `test getting cloud characters from network are as expected`() = runBlockingTest {
        val chars = charInteractor.getAllCloudCharacters()
        Assert.assertEquals(chars.size, 2)
    }

    @Test
    fun `test getting single cloud character from network is as expected`() = runBlockingTest {
        val char = charInteractor.getCloudCharacterById("salazar")
        Assert.assertEquals(char.description, "human fighter")
    }

    @Test
    fun `test adding cloud character to network is as expected`() = runBlockingTest {
        val id = charInteractor.addNewCloudCharacter(BaseCharacter(null, null,
            "Salazar", "human fighter", 12, 2))
        Assert.assertEquals(id, "salazar")
    }

    @Test
    fun `test updating cloud character to network is as expected`() = runBlockingTest {
        val id = charInteractor.updateCloudCharacter(BaseCharacter(null, "salazar",
            "Salazar", "human fighter", 12, 2))
        Assert.assertEquals(id, "salazar")
    }


}