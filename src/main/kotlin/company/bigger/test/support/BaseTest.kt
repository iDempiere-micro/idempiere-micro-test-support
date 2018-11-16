package company.bigger.test.support

import org.junit.runner.RunWith
import kotliquery.HikariCP
import org.junit.Before
import org.junit.Test
import org.junit.runners.JUnit4

/**
 * Base Unit test running without the web environment
 */
@RunWith(JUnit4::class)
open class BaseTest {
    companion object {
        private var setUpIsDone = false
        private const val localhost = "jdbc:postgresql://localhost:5432/idempiere"
        private const val user = "adempiere"
    }
    /**
     * At the beginning of the tests setup the Hikari Connection Pool to connect to the Ini-provided PgSQL
     */
    @Before
    open fun prepare() {
        if (!setUpIsDone) {
            HikariCP.default(localhost, user, user)
            setUpIsDone = true
        }
    }

    @Test
    fun test() {
    }
}
