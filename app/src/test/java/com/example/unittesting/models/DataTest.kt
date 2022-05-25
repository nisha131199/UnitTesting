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
    private lateinit var fakeRepository: Repository

    @Before
    fun beforeTest() {
        data = Data("TESTING", null)
        val context: Context = InstrumentationRegistry.getInstrumentation().context
        fakeRepository = Repository(context)
    }

    @Test
    fun getData() = runBlocking {
        val data = Data("Test1", "test1@gmail.com", 1)
        val data2 = Data("Test2", "test2@gmail.com", 2)
        val data3 = Data("Test3", "test3@gmail.com", 3)
        val data4 = Data("Test4", "test4@gmail.com", 4)

        val insert = fakeRepository.insert(data)
        assertThat(insert).isNotNull()

        fakeRepository.insertAllData(listOf(data2,data3,data4))

        val allData = fakeRepository.getData()
        assertFalse(allData.contains(data))

//        assertTrue(allData.contains(data))

        println("data size -> ${allData.size}")

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