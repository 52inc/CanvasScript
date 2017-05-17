/*
 * Copyright (c) 2017 52inc
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

package com.ftinc.canvasscript.params;


import android.graphics.Canvas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class RestoreParamsTest {

    @Mock Canvas canvas;


    @Test
    public void shouldCreateParamWithoutCount() {
        RestoreParams params = new RestoreParams();
        assertThat(params.getCount(), is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldCreateParamWithCount() {
        RestoreParams params = new RestoreParams(5);
        assertThat(params.getCount(), is(5));
    }


    @Test
    public void shouldUpdateCountWhenSet() {
        RestoreParams params = new RestoreParams();
        params.setCount(5);
        assertThat(params.getCount(), is(5));
    }


    @Test
    public void shouldRestoreCanvasWithoutCount() {
        RestoreParams params = new RestoreParams();

        int result = params.draw(canvas);

        verify(canvas).restore();
        assertThat(result, is(0));
    }


    @Test
    public void shouldRestoreCanvasToCount() {
        RestoreParams params = new RestoreParams(5);

        int result = params.draw(canvas);

        verify(canvas).restoreToCount(5);
        assertThat(result, is(0));
    }
}