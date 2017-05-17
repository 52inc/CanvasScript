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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SaveParamsTest {

    private static final int SAVE_COUNT = 5;

    @Mock Canvas canvas;


    @Before
    public void setUp() {
        when(canvas.save()).thenReturn(SAVE_COUNT);
        when(canvas.save(anyInt())).thenReturn(SAVE_COUNT);
    }


    @Test
    public void shouldSaveCanvasWithoutFlags() {
        SaveParams params = new SaveParams();

        int result = params.draw(canvas);

        verify(canvas).save();
        assertThat(result, is(SAVE_COUNT));
    }


    @Test
    public void shouldSaveCanvasWithFlags() {
        SaveParams params = new SaveParams(Canvas.ALL_SAVE_FLAG);

        int result = params.draw(canvas);

        verify(canvas).save(Canvas.ALL_SAVE_FLAG);
        assertThat(result, is(SAVE_COUNT));
    }
}