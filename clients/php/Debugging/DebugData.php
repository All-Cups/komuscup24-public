<?php

namespace Debugging {
    require_once 'Debugging/Color.php';
    require_once 'Model/Vec2Double.php';
    require_once 'Stream.php';

    /**
     * Data for debug rendering
     */
    abstract class DebugData
    {
        /**
         * Write DebugData to output stream
         */
        abstract function writeTo(\OutputStream $stream): void;

        /**
         * Read DebugData from input stream
         */
        static function readFrom(\InputStream $stream): DebugData
        {
            $tag = $stream->readInt32();
            if ($tag == \Debugging\DebugData\Circle::TAG) {
                return \Debugging\DebugData\Circle::readFrom($stream);
            }
            if ($tag == \Debugging\DebugData\Line::TAG) {
                return \Debugging\DebugData\Line::readFrom($stream);
            }
            if ($tag == \Debugging\DebugData\Rect::TAG) {
                return \Debugging\DebugData\Rect::readFrom($stream);
            }
            if ($tag == \Debugging\DebugData\Text::TAG) {
                return \Debugging\DebugData\Text::readFrom($stream);
            }
            throw new Exception('Unexpected tag value');
        }
    }
}

namespace Debugging\DebugData {
    /**
     * Circle
     */
    class Circle extends \Debugging\DebugData
    {
        const TAG = 0;
    
        /**
         * Center
         */
        public \Model\Vec2Double $pos;
        /**
         * Radius
         */
        public float $radius;
        /**
         * Color
         */
        public \Debugging\Color $color;
    
        function __construct(\Model\Vec2Double $pos, float $radius, \Debugging\Color $color)
        {
            $this->pos = $pos;
            $this->radius = $radius;
            $this->color = $color;
        }
    
        /**
         * Read Circle from input stream
         */
        public static function readFrom(\InputStream $stream): Circle
        {
            $pos = \Model\Vec2Double::readFrom($stream);
            $radius = $stream->readDouble();
            $color = \Debugging\Color::readFrom($stream);
            return new Circle($pos, $radius, $color);
        }
        
        /**
         * Write Circle to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(Circle::TAG);
            $this->pos->writeTo($stream);
            $stream->writeDouble($this->radius);
            $this->color->writeTo($stream);
        }
    }

    /**
     * Line (segment)
     */
    class Line extends \Debugging\DebugData
    {
        const TAG = 1;
    
        /**
         * First end
         */
        public \Model\Vec2Double $point1;
        /**
         * Other end
         */
        public \Model\Vec2Double $point2;
        /**
         * Thickness
         */
        public float $width;
        /**
         * Color
         */
        public \Debugging\Color $color;
    
        function __construct(\Model\Vec2Double $point1, \Model\Vec2Double $point2, float $width, \Debugging\Color $color)
        {
            $this->point1 = $point1;
            $this->point2 = $point2;
            $this->width = $width;
            $this->color = $color;
        }
    
        /**
         * Read Line from input stream
         */
        public static function readFrom(\InputStream $stream): Line
        {
            $point1 = \Model\Vec2Double::readFrom($stream);
            $point2 = \Model\Vec2Double::readFrom($stream);
            $width = $stream->readDouble();
            $color = \Debugging\Color::readFrom($stream);
            return new Line($point1, $point2, $width, $color);
        }
        
        /**
         * Write Line to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(Line::TAG);
            $this->point1->writeTo($stream);
            $this->point2->writeTo($stream);
            $stream->writeDouble($this->width);
            $this->color->writeTo($stream);
        }
    }

    /**
     * Rectangle
     */
    class Rect extends \Debugging\DebugData
    {
        const TAG = 2;
    
        /**
         * One of the corners
         */
        public \Model\Vec2Double $corner1;
        /**
         * Opposite corner
         */
        public \Model\Vec2Double $corner2;
        /**
         * Color
         */
        public \Debugging\Color $color;
    
        function __construct(\Model\Vec2Double $corner1, \Model\Vec2Double $corner2, \Debugging\Color $color)
        {
            $this->corner1 = $corner1;
            $this->corner2 = $corner2;
            $this->color = $color;
        }
    
        /**
         * Read Rect from input stream
         */
        public static function readFrom(\InputStream $stream): Rect
        {
            $corner1 = \Model\Vec2Double::readFrom($stream);
            $corner2 = \Model\Vec2Double::readFrom($stream);
            $color = \Debugging\Color::readFrom($stream);
            return new Rect($corner1, $corner2, $color);
        }
        
        /**
         * Write Rect to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(Rect::TAG);
            $this->corner1->writeTo($stream);
            $this->corner2->writeTo($stream);
            $this->color->writeTo($stream);
        }
    }

    /**
     * Text
     */
    class Text extends \Debugging\DebugData
    {
        const TAG = 3;
    
        /**
         * Text to draw
         */
        public string $text;
        /**
         * Position
         */
        public \Model\Vec2Double $pos;
        /**
         * Font size
         */
        public float $size;
        /**
         * Alignment (0 - left, 0.5 - center, 1 - right)
         */
        public float $align;
        /**
         * Color
         */
        public \Debugging\Color $color;
    
        function __construct(string $text, \Model\Vec2Double $pos, float $size, float $align, \Debugging\Color $color)
        {
            $this->text = $text;
            $this->pos = $pos;
            $this->size = $size;
            $this->align = $align;
            $this->color = $color;
        }
    
        /**
         * Read Text from input stream
         */
        public static function readFrom(\InputStream $stream): Text
        {
            $text = $stream->readString();
            $pos = \Model\Vec2Double::readFrom($stream);
            $size = $stream->readDouble();
            $align = $stream->readDouble();
            $color = \Debugging\Color::readFrom($stream);
            return new Text($text, $pos, $size, $align, $color);
        }
        
        /**
         * Write Text to output stream
         */
        public function writeTo(\OutputStream $stream): void
        {
            $stream->writeInt32(Text::TAG);
            $stream->writeString($this->text);
            $this->pos->writeTo($stream);
            $stream->writeDouble($this->size);
            $stream->writeDouble($this->align);
            $this->color->writeTo($stream);
        }
    }
}