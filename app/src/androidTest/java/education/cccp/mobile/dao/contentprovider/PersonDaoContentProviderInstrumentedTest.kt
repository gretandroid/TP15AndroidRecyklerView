package education.cccp.mobile.dao.contentprovider

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import education.cccp.mobile.dao.IPersonDao
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PersonDaoContentProviderInstrumentedTest {

    private var personDao: IPersonDao = PersonDaoContentProvider(
        contentResolver = getInstrumentation()
            .targetContext
            .contentResolver
    )



    @Test
    fun test_dao_initialisation_is_ok() {
        println("personDao.findAll().size : ${personDao.findAll().size}")
    }
}