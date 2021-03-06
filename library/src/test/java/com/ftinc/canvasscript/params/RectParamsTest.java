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
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class RectParamsTest {

    private static final float LEFT = 0f;
    private static final float TOP = 0f;
    private static final float RIGHT = 10f;
    private static final float BOTTOM = 10f;

    @Mock Paint paint;
    @Mock Canvas canvas;


    @Test
    public void shouldDrawUsingPrimitiveBounds() {
        RectParams params = new RectParams(LEFT, TOP, RIGHT, BOTTOM, paint);

        int saveCount = params.draw(canvas);

        verify(canvas).drawRect(LEFT, TOP, RIGHT, BOTTOM, paint);
        assertThat(saveCount, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawUsingRectBounds() {
        Rect rect = mock(Rect.class);
        RectParams params = new RectParams(rect, paint);

        int saveCount = params.draw(canvas);

        verify(canvas).drawRect(rect, paint);
        assertThat(saveCount, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawUsingRectFBounds() {
        RectF rect = mock(RectF.class);
        RectParams params = new RectParams(rect, paint);

        int saveCount = params.draw(canvas);

        verify(canvas).drawRect(rect, paint);
        assertThat(saveCount, is(CanvasParams.NO_SAVE));
    }

}