package az.edu.bhos.l14todoapp.data

import androidx.room.*
import az.edu.bhos.l14todoapp.data.dto.TodoLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(todos: List<TodoLocalDto>)

    @Delete
    suspend fun delete(todo: TodoLocalDto)

    @Query("SELECT * FROM todos")
    fun getAllTodos(): Flow<List<TodoLocalDto>>

    @Query("SELECT * FROM todos WHERE id = :id")
    fun getTodoById(id: String): Flow<TodoLocalDto>
}
