package company.bigger.test.support

import org.junit.runner.RunWith
import kotliquery.HikariCP
import org.junit.Before
import org.junit.Test
import org.junit.runners.JUnit4
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * Base Unit test running without the web environment
 */
@RunWith(JUnit4::class)
open class BaseTest {
    companion object {
        private var setUpIsDone = false
        private val localhost = System.getenv("SESSION_URL") ?: "jdbc:postgresql://localhost:5433/idempiere"
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
}
