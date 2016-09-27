package by.karl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Chosen on 17.09.2016.
 */
@Entity
@Table(name = "user", schema = "messages", catalog = "")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select distinct u from UserEntity u left join fetch u.messagesById"),
        @NamedQuery(name = "User.findByName", query = "select distinct u from UserEntity u left join fetch u.messagesById WHERE u.name = :name")
})
public class UserEntity implements Serializable {
    private int id;
    private String name;
    private Collection<MessageEntity> messagesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<MessageEntity> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<MessageEntity> messagesById) {
        this.messagesById = messagesById;
    }

    @Override
    public String toString() {
        return name;
    }
}
