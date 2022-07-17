package objects

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: commentsObject,
    val copyright: copyrightObject,
    val likes: likesObject,
    val reposts: repostsObject,
    val views: viewsObject,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: donutObject,
    val postponedId: Int
)

class commentsObject(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

class copyrightObject(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

class likesObject(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

class repostsObject(
    val count: Int,
    val userReposted: Boolean
)

class viewsObject(
    val count: Int
)

class donutObject(
    val isDonut: Boolean,
    val paidDuration: Int,
    val canPublishFreeCopy: Boolean,
    val editMode: String
)

object WallService {
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts[0]
    }

    fun update(post: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == index) {
                posts[index] = post.copy(
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
                return true
            }
        }
        return false
    }
}

fun main() {

}