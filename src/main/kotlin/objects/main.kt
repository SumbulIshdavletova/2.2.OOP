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
    val comments: commentsObject?,
    val copyright: copyrightObject,
    val likes: likesObject?,
    val reposts: repostsObject,
    val views: viewsObject?,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: donutObject,
    val postponedId: Int,
    val attachment: Array<Attachment>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (ownerId != other.ownerId) return false
        if (fromId != other.fromId) return false
        if (createdBy != other.createdBy) return false
        if (date != other.date) return false
        if (text != other.text) return false
        if (replyOwnerId != other.replyOwnerId) return false
        if (replyPostId != other.replyPostId) return false
        if (friendsOnly != other.friendsOnly) return false
        if (comments != other.comments) return false
        if (copyright != other.copyright) return false
        if (likes != other.likes) return false
        if (reposts != other.reposts) return false
        if (views != other.views) return false
        if (postType != other.postType) return false
        if (signerId != other.signerId) return false
        if (canPin != other.canPin) return false
        if (canDelete != other.canDelete) return false
        if (canEdit != other.canEdit) return false
        if (isPinned != other.isPinned) return false
        if (markedAsAds != other.markedAsAds) return false
        if (isFavorite != other.isFavorite) return false
        if (donut != other.donut) return false
        if (postponedId != other.postponedId) return false
        if (!attachment.contentEquals(other.attachment)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + ownerId
        result = 31 * result + fromId
        result = 31 * result + createdBy
        result = 31 * result + date
        result = 31 * result + text.hashCode()
        result = 31 * result + replyOwnerId
        result = 31 * result + replyPostId
        result = 31 * result + friendsOnly.hashCode()
        result = 31 * result + (comments?.hashCode() ?: 0)
        result = 31 * result + copyright.hashCode()
        result = 31 * result + (likes?.hashCode() ?: 0)
        result = 31 * result + reposts.hashCode()
        result = 31 * result + (views?.hashCode() ?: 0)
        result = 31 * result + postType.hashCode()
        result = 31 * result + signerId
        result = 31 * result + canPin.hashCode()
        result = 31 * result + canDelete.hashCode()
        result = 31 * result + canEdit.hashCode()
        result = 31 * result + isPinned.hashCode()
        result = 31 * result + markedAsAds.hashCode()
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + donut.hashCode()
        result = 31 * result + postponedId
        result = 31 * result + attachment.contentHashCode()
        return result
    }
}

abstract class Attachment(open val type: String)

open class AudioAttachment(override val type: String) : Attachment(type)
class Audio(override val type: String, val mp3: String) : AudioAttachment(type)
open class VideoAttachment(override val type: String) : Attachment(type)
class Video(override val type: String, val vid: String) : VideoAttachment(type)
open class PhotoAttachment(override val type: String) : Attachment(type)
class Photo(override val type: String, val pic: String) : PhotoAttachment(type)
open class DocAttachment(override val type: String) : Attachment(type)
class Doc(override val type: String, val docs: String) : DocAttachment(type)
open class LinkAttachment(override val type: String) : Attachment(type)
class Link(override val type: String, val link: String) : DocAttachment(type)


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
        posts += Post(
            id = 1,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 2000,
            text = "content2",
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = false,
            comments = null,
            copyright = copyrightObject(1, "link2", "name2", "type2"),
            likes = null,
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
            postponedId = 1,
            attachment = arrayOf(Audio("type","song"))
        )
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((id, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[id] = post.copy(
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
                    postponedId = 1,
                    attachment = arrayOf(Video("type","video"))
                )
                return true
            }

        }
        return false
    }

}


fun main() {

}