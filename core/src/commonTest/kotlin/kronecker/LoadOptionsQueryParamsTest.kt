package kronecker

import kommander.expect
import kommander.expectFunction
import kotlin.test.Test

class LoadOptionsQueryParamsTest {
    @Test
    fun should_transform_a_null_load_options_to_empty_query_string() {
        val options: LoadOptions? = null
        expect(options.toQueryParams()).toBe("")
    }

    @Test
    fun should_transform_a_non_null_load_options_to_a_valid_query_string() {
        val options = LoadOptions(page = 4, limit = 7)
        expect(options.toQueryParams()).toBe("page=4&limit=7")
    }

    @Test
    fun should_transform_a_non_null_load_options_with_a_key_to_a_valid_query_string() {
        val options = LoadOptions(page = 4, limit = 7, key = "test")
        expect(options.toQueryParams()).toBe("page=4&limit=7&key=test")
    }

    @Test
    fun should_be_able_to_construct_a_load_options_from_a_query_string() {
        val query = ""
        var options = LoadOptions.fromQueryStringOrNull(query)
        expect(options).toBe(null)
        options = LoadOptions.fromQueryStringOrNull(null)
        expect(options).toBe(null)
    }

    @Test
    fun should_be_able_to_construct_a_load_options_from_a_valid_query_string() {
        val options = LoadOptions.fromQueryString("page=4&limit=7")
        expect(options).toBe(LoadOptions(page = 4, limit = 7))
    }

    @Test
    fun should_be_able_to_construct_a_load_options_with_a_key_from_a_valid_query_string() {
        val options = LoadOptions.fromQueryString("page=4&limit=7&key=john")
        expect(options).toBe(LoadOptions(page = 4, limit = 7, key = "john"))
    }

    @Test
    fun should_be_able_to_construct_a_load_options_from_a_url() {
        val options = LoadOptions.fromQueryString("https://test.com?page=4&limit=7&key=john")
        expect(options).toBe(LoadOptions(page = 4, limit = 7, key = "john"))
    }

    @Test
    fun should_return_null_from_constructing_a_load_options_with_a_query_string_without_required_fields() {
        val options = LoadOptions.fromQueryStringOrNull("name=jane&age=14")
        expect(options).toBe(null)
    }

    @Test
    fun should_fail_to_construct_a_load_options_with_a_query_string_without_required_fields() {
        val exception = expectFunction {
            LoadOptions.fromQueryString("name=jane&age=14")
        }.toFail()
        expect(exception.message).toBe("Missing parameter page from query string name=jane&age=14")
    }
}