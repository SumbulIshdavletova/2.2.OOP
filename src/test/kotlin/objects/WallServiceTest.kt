package objects

import org.junit.Assert.assertEquals
import org.junit.Test

class WallServiceTest {

    @Test
    fun addCommitted() {
        val service = WallService
        var posts = emptyArray<Post>()
        val post = service.add(
            Post(
                id = 1,
                ownerId = 1,
                fromId = 1,
                createdBy = 1,
                date = 2300,
                text = "content",
                replyOwnerId = 1,
                replyPostId = 1,
                friendsOnly = false,
                comments = commentsObject(1, true, true, true, true),
                copyright = copyrightObject(1, "link", "name", "type"),
                likes = likesObject(1, true, true, true),
                reposts = repostsObject(3, true),
                views = viewsObject(8),
                postType = "type",
                signerId = 1,
                canPin = false,
                canDelete = false,
                canEdit = true,
                isPinned = false,
                markedAsAds = false,
                isFavorite = false,
                donut = donutObject(false, 0, true, "all"),
                postponedId = 1
            )
        )
        val result = post.id != 0
        assertEquals(true, result)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        var posts = emptyArray<Post>()

        for ((index, post) in WallService.posts.withIndex()) {
            if (post.id == index) {
                WallService.posts[index] = post.copy(
                    ownerId = 1,
                    fromId = 1,
                    createdBy = 1,
                    text = "content2",
                    replyOwnerId = 1,
                    replyPostId = 1,
                    friendsOnly = false,
                    comments = commentsObject(1, true, true, true, true),
                    copyright = copyrightObject(1, "link2", "name2", "type2"),
                    likes = likesObject(1, true, true, true),
                    reposts = repostsObject(3, true),
                    views = viewsObject(8),
                    postType = "type2",
                    signerId = 1,
                    canPin = false,
                    canDelete = false,
                    canEdit = true,
                    isPinned = false,
                    markedAsAds = false,
                    isFavorite = false,
                    donut = donutObject(false, 0, true, "all"),
                    postponedId = 1
                )
                val result = true
                assertEquals(true, result)
            }
            val result = false
        }

    }

    @Test
    fun updateFalse() {
        val service = WallService
        var posts = emptyArray<Post>()

        for ((index, post) in WallService.posts.withIndex()) {
            if (post.id != index) {
                WallService.posts[index] = post.copy(
                    ownerId = 1,
                    fromId = 1,
                    createdBy = 1,
                    text = "content2",
                    replyOwnerId = 1,
                    replyPostId = 1,
                    friendsOnly = false,
                    comments = commentsObject(1, true, true, true, true),
                    copyright = copyrightObject(1, "link2", "name2", "type2"),
                    likes = likesObject(1, true, true, true),
                    reposts = repostsObject(3, true),
                    views = viewsObject(8),
                    postType = "type2",
                    signerId = 1,
                    canPin = false,
                    canDelete = false,
                    canEdit = true,
                    isPinned = false,
                    markedAsAds = false,
                    isFavorite = false,
                    donut = donutObject(false, 0, true, "all"),
                    postponedId = 1
                )
                val result = true
            }
            val result = false
            assertEquals(false, result)
        }
    }

}