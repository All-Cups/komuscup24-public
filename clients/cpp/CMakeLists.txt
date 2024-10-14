cmake_minimum_required(VERSION 3.5)
set (CMAKE_CXX_STANDARD 20)
project(komus24)

# OS and compiler checks.
if(WIN32)
    add_definitions(-DWIN32)
    SET(PROJECT_LIBS Ws2_32.lib)
endif()

set(HEADERS
    "DebugInterface.hpp"
    "MyStrategy.hpp"
    "Stream.hpp"
    "TcpStream.hpp"
    "codegame/ClientMessage.hpp"
    "codegame/ServerMessage.hpp"
    "debugging/DebugCommand.hpp"
    "model/CityCell.hpp"
    "model/CityType.hpp"
    "model/Constants.hpp"
    "model/DebugData.hpp"
    "model/DebugState.hpp"
    "model/MinMaxRangeLong.hpp"
    "model/Order.hpp"
    "model/Player.hpp"
    "model/PlayerView.hpp"
    "model/Quest.hpp"
    "model/Traffic.hpp"
    "model/Vec2Double.hpp"
    "model/Vec2Int.hpp"
    "model/Vehicle.hpp"
    "model/VehicleOrder.hpp"
    "model/VehicleType.hpp"
)
set (SRC
    "DebugInterface.cpp"
    "MyStrategy.cpp"
    "Stream.cpp"
    "TcpStream.cpp"
    "codegame/ClientMessage.cpp"
    "codegame/ServerMessage.cpp"
    "debugging/DebugCommand.cpp"
    "main.cpp"
    "model/CityCell.cpp"
    "model/CityType.cpp"
    "model/Constants.cpp"
    "model/DebugData.cpp"
    "model/DebugState.cpp"
    "model/MinMaxRangeLong.cpp"
    "model/Order.cpp"
    "model/Player.cpp"
    "model/PlayerView.cpp"
    "model/Quest.cpp"
    "model/Traffic.cpp"
    "model/Vec2Double.cpp"
    "model/Vec2Int.cpp"
    "model/Vehicle.cpp"
    "model/VehicleOrder.cpp"
    "model/VehicleType.cpp"
)
SET_SOURCE_FILES_PROPERTIES(${HEADERS} PROPERTIES HEADER_FILE_ONLY TRUE)
include_directories(".")
add_executable(komus24 ${HEADERS} ${SRC})
TARGET_LINK_LIBRARIES(komus24 ${PROJECT_LIBS})