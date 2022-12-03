package ru.netology.nmedia.repository

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun share(id: Long)
}
class PostRepositoryInMemoryImpl : PostRepository {
    private var posts = listOf(
        Post(
        12,
        "Нетология. Университет интернет-профессий",
        "24 ноября в 19:21",
        "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
        false,
        10,
        98,
        true
    ),
        Post(
            13,
            "Нетология. Университет интернет-профессий",
            "24 ноября в 19:21",
            "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
            false,
            1350,
            990,
            false
        ),
        Post(
            14,
            "Нетология. Университет интернет-профессий",
            "24 ноября в 19:21",
            "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
            false,
            1350,
            990,
            false
        ),
        Post(
            15,
            "Нетология. Университет интернет-профессий",
            "24 ноября в 19:21",
            "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
            false,
            1350,
            990,
            false
        ),
        Post(
            16,
            "Нетология. Университет интернет-профессий",
            "24 ноября в 19:21",
            "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
            false,
            600,
            990,
            false
        ),
        Post(
            17,
            "Нетология. Университет интернет-профессий",
            "24 ноября в 19:21",
            "Привет, это новая Нетология! Когда-то  встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
            false,
            1600235,
            990,
            false
        ),
        Post(
            18,
            "Нетология. Университет интернет-профессий",
            "24 ноября в 19:21",
            "Привет, это новая Нетология! Когда-то Нетот новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
            false,
            50,
            0,
            false
        ),

    )
    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data

//    @SuppressLint("SuspiciousIndentation")
    override fun likeById(id: Long) {
        posts = posts.map {
            if(it.id != id) it else it.copy(likedByMe = !it.likedByMe, likes = it.likes++)
                //likes = if(it.likedByMe) it.likes -- else it.likes ++)

        }
    data.value = posts
    }
    override fun share(id: Long){
        posts = posts.map {
            if(it.id != id) it else it.copy(shareByMe =  true, shares = it.shares++)


        }
        data.value = posts
    }
}
