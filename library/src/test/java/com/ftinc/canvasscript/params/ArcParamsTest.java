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
import android.graphics.RectF;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ArcParamsTest {

    private static final float LEFT = 0f;
    private static final float TOP = 0f;
    private static final float RIGHT = 10f;
    private static final float BOTTOM = 15f;
    private static final float START_ANGLE = 0f;
    private static final float SWEEP_ANGLE = 180f;

    @Mock Paint paint;
    @Mock Canvas canvas;


    @Test
    public void shouldDrawArc() {
        RectF rect = mock(RectF.class);
        when(rect.toString()).thenReturn("");
        rect.left = LEFT;
        rect.top = TOP;
        rect.right = RIGHT;
        rect.bottom = BOTTOM;
        ArcParams params = new ArcParams(rect, START_ANGLE, SWEEP_ANGLE, false, paint);

        int result = params.draw(canvas);

        verify(canvas).drawArc(rect, START_ANGLE, SWEEP_ANGLE, false, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }
}