/*
 * FreeOTP
 *
 * Authors: Nathaniel McCallum <npmccallum@redhat.com>
 *
 * Copyright (C) 2013  Nathaniel McCallum, Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fedorahosted.freeotp.add

import android.app.Activity
import android.text.Editable

class AddSecretTextWatcher(activity: Activity) : AddTextWatcher(activity) {

    override fun afterTextChanged(s: Editable) {
        if (s.length != 0) {
            // Ensure that = is only permitted at the end
            var haveData = false
            for (i in s.length - 1 downTo 0) {
                val c = s[i]
                if (c != '=')
                    haveData = true
                else if (haveData)
                    s.delete(i, i + 1)
            }
        }

        super.afterTextChanged(s)
    }
}
