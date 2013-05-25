package fr.tkeunebr.gravatar.sample;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public final class GravatarActivity extends ListActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.gravatar_activity);

    List<User> users = new ArrayList<User>(10);
    for (int i = 1; i <= 10; i++) {
      users.add(new User("User " + i, i % 2 == 0 ? "thomas.keunebroek@gmail.com" : "unknown@fake.com"));
    }

    GravatarAdapter adapter = new GravatarAdapter(this);
    adapter.updateUsers(users);

    setListAdapter(adapter);
  }

  static final class User {
    String name;
    String email;

    public User(String name, String email) {
      this.name = name;
      this.email = email;
    }
  }
}
