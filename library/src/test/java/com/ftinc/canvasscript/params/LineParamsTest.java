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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class LineParamsTest {

    private static final float STARTX = 0f;
    private static final float ENDX = 10f;
    private static final float STARTY = 0f;
    private static final float ENDY = 40f;

    @Mock Paint paint;
    @Mock Canvas canvas;


    @Test
    public void shouldDrawSingleLine() {
        LineParams params = new LineParams(STARTX, STARTY, ENDX, ENDY, paint);

        int result = params.draw(canvas);

        verify(canvas).drawLine(STARTX, STARTY, ENDX, ENDY, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawMultipleLines() {
        float[] pts = new float[] {
                STARTX, STARTY, ENDX, ENDY,
                0f, 0f, 10f, 10f,
                0f, 0f, 500f, 500f
        };
        LineParams params = new LineParams(pts, paint);

        int result = params.draw(canvas);

        verify(canvas).drawLines(pts, 0, pts.length, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }
}