gravatar-android
================

A lightweight Java Gravatar library optimized for Android.

![Gravatar-android sample screenshot](static/gravatar_sample_screenshot.png "Gravatar-android sample screenshot")


Usage
================

Gravatar-android features a simple and fluid API. It fully supports Gravatar image requests as
described in the official documentation: http://en.gravatar.com/site/implement/images/ and automatically computes
the request URL.

    String gravatarUrl = Gravatar.init().with(user.email).force404().size(Gravatar.MAX_IMAGE_SIZE_PIXEL).build();
    
Using the awesome [Picasso](https://github.com/square/picasso) from Square, you can populate your AbsListView with
your users' faces in one line of code (usually in BaseAdapter.getView()).

    Picasso.with(mContext)
           .load(gravatarUrl)
           .into((ImageView) convertView.findViewById(R.id.user_avatar));
            
You can have a look at the sample app for a more complete implementation.

If you need to, you can provide the library with other default params by creating your own instance of Gravatar
using the build-in Gravatar.Builder class. In this case, the recommanded approach
is to store the resulting Gravatar object as a singleton in your application.

    Gravatar myGravatar = new Gravatar.Builder().ssl().build();
    String gravatarUrl = myGravatar.with(user.email).build();

Download
================

You can download the 
[latest JAR](https://github.com/tkeunebr/gravatar-android/blob/master/gravatar-android-sample/libs/gravatar-android-1.0.jar) 
used in the sample app and add it as a dependency to your project. I'll be happy to consider and review each of your
pull requests.


License
================

    Copyright 2013 tkeunebr.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
