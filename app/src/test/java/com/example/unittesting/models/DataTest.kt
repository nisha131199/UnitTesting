package com.example.unittesting.models

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.example.unittesting.MainActivity
import com.example.unittesting.storage.Repository
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class DataTest {

    private var data: Data? = null
    @Mock
    private lateinit var fakeRepository: Repository

    @Before
    fun beforeTest() {
        data = Data("TESTING", null)
        val context: Context = InstrumentationRegistry.getInstrumentation().context
        fakeRepository = Repository(context)
    }

    @Test
    fun getData() = runBlocking {
        val data = Data("Test1", "test1@gmail.com")

        val insert = fakeRepository.insert(data)
        assertThat(insert).isNotNull()

        val allData = fakeRepository.getData()
        assertThat(allData).doesNotContain(data)
        assertTrue(allData.contains(data))
        println("data ${allData[0].name}")

        val delete = fakeRepository.delete(data)
        assertThat(delete).isNotNull()

    }

    @Test
    fun testData() {
        assertThat(data).isNotNull()

        assertThat(data?.getData()).isNotNull()
        //checking if same instance
        assertThat(data).isNotInstanceOf(MainActivity::class.java)
        assertThat(data).isNotSameInstanceAs(Data(null, null))
        //check if data.name matched
        assertThat(data?.name).ignoringCase().isEqualTo("testing")

        assertThat(listOf("1", "2", "3"))
            .containsExactlyElementsIn(listOf("3", "2", "1"))
    }
}